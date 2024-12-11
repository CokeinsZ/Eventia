import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DetalleEventoComponent } from './components/detalle-evento/detalle-evento.component';
import { GestionarSaldoComponent } from './components/gestionar-saldo/gestionar-saldo.component';
import { ReservasComponent } from './components/reservas/reservas.component';
import { HistorialComponent } from './components/historial/historial.component';
import { PanelAdministradorComponent } from './components/panel-administrador/panel-administrador.component';
import { OrgEventoComponent } from './components/org-evento/org-evento.component';
import { OrgComunidadComponent } from './components/org-comunidad/org-comunidad.component';
import { OrgIngresosComponent } from './components/org-ingresos/org-ingresos.component';
import { NewPublishComponent } from './components/new-publish/new-publish.component';
import { GestionAdminComponent } from './components/panel-administrador/gestion-admin/gestion-admin.component';
import { AnalisisAdminComponent } from './components/panel-administrador/analisis-admin/analisis-admin.component';
import { EventListComponent } from './components/panel-administrador/gestion-admin/event-list/event-list.component';
import { ReservasListComponent } from './components/panel-administrador/gestion-admin/reservas-list/reservas-list.component';
import { UsersListComponent } from './components/panel-administrador/gestion-admin/users-list/users-list.component';
import { UpdatePublishComponent } from './components/panel-administrador/gestion-admin/event-list/update-publish/update-publish.component';
import { IngresosListComponent } from './components/panel-administrador/analisis-admin/ingresos-list/ingresos-list.component';
import { RatedEventsListComponent } from './components/panel-administrador/analisis-admin/rated-events-list/rated-events-list.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

// aqui se almacenan todas las rutas utilizados al clickear en botones
export const routes: Routes = [
    {
        path: 'login', component: LoginComponent,
    },
    {
        path: 'register', component: RegisterComponent,
    },
    {
        path: 'home', component: HomeComponent,
    },
    {
        path: '', component: HomeComponent
    },
    {
        path: 'evento/:id', component: DetalleEventoComponent,
    },
    {
        path: 'cartera', component: GestionarSaldoComponent,
    },
    {
        path: 'reservas', component: ReservasComponent,
    },
    {
        path: 'historial', component: HistorialComponent,
    },
    {
        path: 'p/organizador', component: OrgEventoComponent,
    },
    {
        path: 'p/administrador', component: PanelAdministradorComponent,
    },
    {
        path: 'p/administrador/gestion', component: GestionAdminComponent,
    },
    {
        path: 'p/administrador/gestion/Evento', component: EventListComponent,
    },
    {
        path: 'p/administrador/gestion/Reservas', component: ReservasListComponent,
    },
    {
        path: 'p/administrador/gestion/Usuarios', component: UsersListComponent,
    },
    {
        path: 'updatepublish', component: UpdatePublishComponent,
    },
    {
        path: 'p/administrador/analisis', component: AnalisisAdminComponent,
    },
    {
        path: 'p/administrador/gestion/ingresos', component: IngresosListComponent,
    },
    {
        path: 'p/administrador/gestion/eventosRate', component: RatedEventsListComponent,
    },
    {
        path: 'p/organizador/comunidad', component: OrgComunidadComponent,
    },
    {
        path: 'p/organizador/ingresos', component: OrgIngresosComponent,
    },
    {
        path: 'new-publish', component: NewPublishComponent,
    }
];
