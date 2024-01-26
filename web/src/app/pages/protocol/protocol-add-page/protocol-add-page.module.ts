import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CommonsModule } from '@base/shared/pages/commons.module';
import { EditPageModule } from '@base/shared/pages/edit-page.module';
import { ProtocolAddPageRoutingModule } from './protocol-add-page-routing.module';
import { ProtocolAddPageComponent } from './protocol-add-page.component';
import {MatChipsModule} from "@angular/material/chips";


@NgModule({
    imports: [
        CommonModule,
        ProtocolAddPageRoutingModule,
        CommonsModule,
        EditPageModule,
        MatChipsModule,
    ],
  declarations: [
    ProtocolAddPageComponent
  ],
})
export class ProtocolAddPageModule {
}
