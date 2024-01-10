package es.consumo.junta_arbitral.modules.permission.model.dto;

import java.io.Serializable;

import es.consumo.junta_arbitral.commons.dto.LongIdModel;
import es.consumo.junta_arbitral.modules.permission.model.entity.PermissionEntity;
import es.consumo.junta_arbitral.modules.role.model.constants.PermissionScope;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO implements Serializable, LongIdModel {

    private Long id;
    private PermissionScope scope;
    private boolean check;
    private PermissionEntity permission;
}
