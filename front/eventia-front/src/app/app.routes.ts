import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DetalleEventoComponent } from './components/detalle-evento/detalle-evento.component';
import { GestionarSaldoComponent } from './components/gestionar-saldo/gestionar-saldo.component';
import { ReservasComponent } from './components/reservas/reservas.component';
import { HistorialComponent } from './components/historial/historial.component';

// aqui se almacenan todas las rutas utilizados al clickear en botones
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
    {
        path:'cartera', component:GestionarSaldoComponent,
    },
    {
        path:'reservas', component:ReservasComponent,
    },
    {
        path:'historial', component:HistorialComponent,
    }
];
