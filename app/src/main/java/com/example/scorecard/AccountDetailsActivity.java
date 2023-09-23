package com.example.scorecard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AccountDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Transaction> transactionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_details);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.transactionRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the transaction list (Replace with your actual transaction data)
        transactionList = getSampleTransactionData();

        // Create an adapter and set it to the RecyclerView
        TransactionAdapter adapter = new TransactionAdapter(transactionList);
        recyclerView.setAdapter(adapter);
    }

    // Method to generate sample transaction data (Replace with your actual data source)
    private List<Transaction> getSampleTransactionData() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("2023-09-01", "Online Store", "$50.00"));
        transactions.add(new Transaction("2023-09-05", "Coffee Shop", "$5.75"));
        transactions.add(new Transaction("2023-09-10", "Gas Station", "$30.25"));
        // Add more transactions here
        return transactions;
    }

    // Transaction model class (Replace with your actual Transaction class)
    private static class Transaction {
        private String date;
        private String merchant;
        private String amount;

        public Transaction(String date, String merchant, String amount) {
            this.date = date;
            this.merchant = merchant;
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public String getMerchant() {
            return merchant;
        }

        public String getAmount() {
            return amount;
        }
    }

    // RecyclerView adapter class
    private static class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
        private List<Transaction> transactionList;

        public TransactionAdapter(List<Transaction> transactionList) {
            this.transactionList = transactionList;
        }

        @NonNull
        @Override
        public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_transaction_items, parent, false);
            return new TransactionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
            Transaction transaction = transactionList.get(position);
            holder.bind(transaction);
        }

        @Override
        public int getItemCount() {
            return transactionList.size();
        }

        public static class TransactionViewHolder extends RecyclerView.ViewHolder {
            private TextView dateTextView;
            private TextView merchantTextView;
            private TextView amountTextView;

            public TransactionViewHolder(@NonNull View itemView) {
                super(itemView);
                dateTextView = itemView.findViewById(R.id.dateTextView);
                merchantTextView = itemView.findViewById(R.id.merchantTextView);
                amountTextView = itemView.findViewById(R.id.amountTextView);
            }

            public void bind(Transaction transaction) {
                dateTextView.setText(transaction.getDate());
                merchantTextView.setText(transaction.getMerchant());
                amountTextView.setText(transaction.getAmount());
            }
        }
    }
}
