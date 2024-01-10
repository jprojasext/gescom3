package es.consumo.junta_arbitral.modules.campaignType.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CampaignTypeDTO implements Serializable {

    private Long id;
    private String name;

}
