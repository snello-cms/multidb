package io.snello.multidb.annotations;

import javax.enterprise.util.AnnotationLiteral;

public class CustomerEventQualifier extends AnnotationLiteral<CustomerEvent> implements CustomerEvent {

    String customerEventType;

    public CustomerEventQualifier(String customerEventType) {
        this.customerEventType = customerEventType;
    }

    @Override
    public String value() {
        return customerEventType;
    }
}
