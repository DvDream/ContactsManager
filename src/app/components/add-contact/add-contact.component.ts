import { Component, OnInit } from '@angular/core';
import { Contact } from 'src/app/models/contact.model';
import { ContactService } from 'src/app/services/contact.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent implements OnInit {

  contact: Contact = {
    surname: '',
    name: '',
    phone_number: '',
    address: '',
    geo_data: '',
    other_info: ''
  };
  submitted = false;
  
  constructor( private contactService: ContactService, private router: Router) { } //new

  ngOnInit(): void { 

  }

  saveContact(): void {
    const data = {
      surname: this.contact.surname,
      name: this.contact.name,
      phone_number : this.contact.phone_number,
      address : this.contact.address,
      geo_data : this.contact.geo_data,
      other_info : this.contact.other_info
    };

    this.contactService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newContact(): void {
    this.submitted = false;
    this.contact = {
      surname: '',
      name: '',
      phone_number: '',
      address: '',
      geo_data: '',
      other_info: ''
    };
    this.router.navigateByUrl('/contacts');
  }

}
