import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DetalleEventoComponent } from './components/detalle-evento/detalle-evento.component';

export const routes: Routes = [
    {
        path:"home", component: HomeComponent,
    },
    {
        path:'', component: HomeComponent
    },
    {
        path:"evento", component: DetalleEventoComponent,
    },
];
