import { Component } from '@angular/core';
import { AcordeonComponent } from './acordeon/acordeon.component';

@Component({
  selector: 'app-header',
  imports: [AcordeonComponent],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

}
