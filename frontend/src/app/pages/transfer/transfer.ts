import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { TransactionService } from '../../services/transaction';

@Component({
  selector: 'app-transfer',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './transfer.html',
  styleUrls: ['./transfer.css']
})
export class TransferComponent {
  message = '';
  transferForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private transactionService: TransactionService
  ) {
    this.transferForm = this.fb.group({
      fromAccountNumber: ['', Validators.required],
      toAccountNumber: ['', Validators.required],
      amount: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.transferForm.invalid) return;

    this.transactionService.transfer(this.transferForm.value).subscribe({
      next: (res: any) => this.message = res,
      error: (err: any) => this.message = err.error?.error || 'Transfer failed'
    });
  }
}