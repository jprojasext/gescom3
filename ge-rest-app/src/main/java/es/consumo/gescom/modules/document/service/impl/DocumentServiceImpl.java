package es.consumo.gescom.modules.document.service.impl;


import es.consumo.gescom.commons.db.entity.StatefulEntity;
import es.consumo.gescom.modules.campaign.model.entity.CampaignEntity;
import es.consumo.gescom.modules.document.model.entity.DocumentEntity;
import es.consumo.gescom.commons.db.repository.GESCOMRepository;
import es.consumo.gescom.commons.service.EntityCrudService;
import es.consumo.gescom.commons.service.ReadService;
import es.consumo.gescom.modules.document.repository.DocumentRepository;
import es.consumo.gescom.modules.document.service.DocumentService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author serikat
 */
@Service
public class DocumentServiceImpl extends EntityCrudService<DocumentEntity, Long> implements DocumentService {
    @Value("${path.documentos}")
    private String repoPath;
    private final ReadService<CampaignEntity, Long> campaingService;

    @Autowired
    private DocumentRepository documentRepository;


    @Autowired
    public DocumentServiceImpl(GESCOMRepository<DocumentEntity, Long> repository,
                               ReadService<CampaignEntity, Long> campaignService) {
        super(repository);
        this.campaingService = campaignService;
    }

    @Override
    public Optional<DocumentEntity> findById(Long id) {
        Optional<DocumentEntity> optional = super.findById(id);
        if (optional.isPresent()) {
            DocumentEntity document = optional.get();
            try {
                document.setBase64(getFile(document));
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }
        }
        return optional;
    }

    @Override
    protected DocumentEntity performCreate(DocumentEntity payload) {
        boolean exits = campaingService.exitsById(payload.getCampaignId());
        if (!exits) {
            throw new RuntimeException("solictud campaña no existe");
        }
        payload.setCreateAt(LocalDateTime.now());
        DocumentEntity entity = super.performCreate(payload);
        try {
            String path = updLoadFile(entity.getCampaignId(), entity.getName(), payload.getBase64());
            entity.setPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return repository.save(entity);
    }


    private String updLoadFile(long campaignId, String name, String base64) throws IOException {
        Path repo = getFilePath(campaignId);

        if ((Files.notExists(repo))) {
            Files.createDirectories(repo);
        }
        String md5 = DigestUtils.md5Hex(name).toUpperCase();
        Path file = Path.of(repo.toString(), "/", md5);
        Files.deleteIfExists(file);
        Path create = Files.createFile(file);
        Files.write(create, base64.getBytes());

        return md5;
    }

    private Path getFilePath(long campaingId) {
        return Path.of(repoPath, "/campaign/attachment/", String.valueOf(campaingId));
    }

    private String getFile(DocumentEntity documentEntity) throws IOException {
        Path file = Path.of(getFilePath(documentEntity.getCampaignId()).toString(), "/", documentEntity.getPath());
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            return reader.lines().collect(Collectors.joining());
        }
    }

    @Override
    public List<DocumentEntity> findDocumentByCampaignId(Long idCampaign) {
        List<DocumentEntity> optional = documentRepository.findDocumentByCampaignId(idCampaign);
        if (!optional.isEmpty()) {
            optional.forEach( documentEntity -> {
                try {
                    documentEntity.setBase64(getFile(documentEntity));
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                }

            });
        }
        return optional;
    }

    @Override
    protected void performDelete(DocumentEntity data) {
        data.setState(2);
        repository.save(data);
    }

}
