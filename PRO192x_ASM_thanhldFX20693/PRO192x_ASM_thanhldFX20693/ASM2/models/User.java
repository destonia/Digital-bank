package PRO192x_ASM_thanhldFX20693.ASM2.models;

import PRO192x_ASM_thanhldFX20693.ASM2.services.Validate;
import PRO192x_ASM_thanhldFX20693.Common;

public class User {
    private String name;
    private String customerId;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String cccdNumber) {
        Validate validate = new Validate();
        if (validate.validateCccd(cccdNumber)) {
            this.customerId = cccdNumber;
        }
    }
}
