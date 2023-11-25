package model.Order;

import model.Product.Product;

import java.util.Date;
import java.util.List;

public class Invoice {
    private Recipient recipient;
    private List<Product> products;
    private List<Integer> quantities;
    private Date issueDate;
    private String invoiceNumber;

    public Invoice(Recipient recipient, List<Product> products, List<Integer> quantities, Date issueDate, String invoiceNumber) {
        this.recipient = recipient;
        this.products = products;
        this.quantities = quantities;
        this.issueDate = issueDate;
        this.invoiceNumber = invoiceNumber;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
