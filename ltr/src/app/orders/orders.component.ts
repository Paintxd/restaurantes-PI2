import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { menuOrders, OrdersModel } from './orders.models';
import { CadOrdersService } from './orders.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {

  frmOrders: FormGroup;
  hide3 = true;
  ordersModule: OrdersModel = new OrdersModel();

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private cadOrdersService: CadOrdersService,

    ) {

    this.initFormOrders();
  }
  ngOnInit(): void {
     null;
  }

  initFormOrders() {
    this.frmOrders = this.fb.group({

      clientId: [null, [Validators.required]],
      employeeId: [null, [Validators.required]],
      restaurantId: [null, [Validators.required]],
      menuOrders: this.fb.group({
        menuId: [null, [Validators.required]],
        quantity:[null, [Validators.required]],
      })

    });
  }
  submit() {
    Object.assign(this.ordersModule, this.frmOrders.value);

    //this.loaderService.showSpinner();
    this.cadOrdersService.post(this.ordersModule).subscribe(res => {

      console.warn(res);

      if (res.success) {
        //this.loaderService.closeSpinner();
       // this.toastr.success('Cadastrado com sucesso.', 'Cadastro de cliente');
        this.frmOrders.reset();
        //this.dgRef.close(res.data);
        console.log("Cadastrou");
      } else {
        console.error(res);
        //this.toastr.error(res.errors, 'Cadastro de cliente')
      }
    },(err: HttpErrorResponse) => {
      //this.loaderService.closeSpinner();
      console.warn(err);
      //this.toastr.error(err.error.errors, '');
    });

  }

}
