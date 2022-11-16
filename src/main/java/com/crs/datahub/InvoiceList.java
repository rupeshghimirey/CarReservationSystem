package com.crs.datahub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InvoiceList {

    private static List<Invoice> invoiceList = new ArrayList<>();

    public static List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public static void addToInvoiceList(Invoice invoice) {
        InvoiceList.invoiceList.add(invoice);
    }

    public static void removeFromInvoiceList(Invoice invoice) {
        InvoiceList.invoiceList.remove(invoice);
    }

}
