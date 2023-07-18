package PRO192x_ASM_thanhldFX20693.ASM3.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static PRO192x_ASM_thanhldFX20693.Common.dateFormat;

public class Transaction {
    private String id;
    private double amount;
    private String time;
    private boolean status;

    public Transaction(double amount, boolean status) {
        this.id = String.valueOf(UUID.randomUUID());
        this.time = dateFormat.format(Calendar.getInstance().getTime());
        this.amount = amount;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public String getId() {
        return id;
    }

    public boolean getStatus(){
        return status;
    }
}
