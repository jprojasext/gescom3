import { SimpleModel, StatefulAltModel, StatefulModel } from './common';
import {TypeCampaign} from "@libs/sdk/typeCampaign";
import { Ambit } from './ambit';
import { AutonomousCommunity } from "@libs/sdk/autonomousCommunity";
import { Proponent } from "@libs/sdk/proponent";
import { Specialist } from "@libs/sdk/specialist";
import { AppQuerySource } from '@libs/commons';
import { PhaseCampaign } from '@libs/sdk/phaseCampaign';

/**
 * Default Campaign structure.
 */
export interface Campaign extends SimpleModel, StatefulModel {

  year: number;
  codeCpa: string;
  nameCampaign: string;
  campaignType: TypeCampaign;
  ambit: Ambit;
  autonomousCommunityResponsible: string;
  phaseCampaign: PhaseCampaign | null;

}


/**
 * Create a new Campaign request structure.
 */
export interface CreateCampaign {
  id: number | null;

  year: number | null;
  codeCpa: string | null;
  nameCampaign: string | null;
  campaignType: TypeCampaign | null;
  ambit: Ambit | null;
  autonomousCommunityResponsible: AutonomousCommunity | null;
  participants: AutonomousCommunity[] | null;
  proponents: Proponent[] | null;
  specialists: Specialist[] | null;

}

export interface CampaignForm {

  id: number | null;

  year: number | null;
  codeCpa: string | null;
  nameCampaign: string | null;
  campaignType: TypeCampaign | null;
  ambit: Ambit | null;
  autonomousCommunityResponsible: AutonomousCommunity | null;
  participants: AutonomousCommunity[] | null;
  proponents: Proponent[] | null;
  specialists: Specialist[] | null;
  phaseCampaign: PhaseCampaign | null;
  createdAt?: string;
  updatedAt?: string;
  state?: number | null;

}


export interface CampaignFilterForm extends AppQuerySource {
  nameCampaign?: string;
  year?: string;
  campaignType?: string;
  ambit?: string;
  createdAtGTE?: string;
  createdAtLTE?: string;
  updatedAtGTE?: string;
  updatedAtLTE?: string;

}

