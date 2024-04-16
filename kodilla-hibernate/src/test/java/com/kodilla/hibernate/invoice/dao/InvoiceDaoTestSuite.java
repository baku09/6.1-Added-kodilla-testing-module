package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Potato");
        Product product2 = new Product("Tomato");

        Item item1 = new Item(new BigDecimal(5), 10, new BigDecimal(50));
        Item item2 = new Item(new BigDecimal(15), 10, new BigDecimal(150));
        Item item3 = new Item(new BigDecimal(100), 7, new BigDecimal(700));

        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);

        Invoice invoice = new Invoice("123456");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        int itemsSize = invoice.getItems().size();
        int itemId = invoice.getItems().get(0).getId();

        //Then
        assertEquals(3, itemsSize);
        assertNotEquals(0, id);
        assertNotEquals(0, itemId);

        var item1FromInvoice = invoice.getItems().get(0);
        assertEquals(item1FromInvoice.getProduct(), product1);
        assertEquals(item1FromInvoice.getPrice(), new BigDecimal(5));
        assertEquals(item1FromInvoice.getQuantity(), 10);
        assertEquals(item1FromInvoice.getValue(), new BigDecimal(50));

        var item2FromInvoice = invoice.getItems().get(1);
        assertEquals(item2FromInvoice.getProduct(), product1);
        assertEquals(item2FromInvoice.getPrice(), new BigDecimal(15));
        assertEquals(item2FromInvoice.getQuantity(), 10);
        assertEquals(item2FromInvoice.getValue(), new BigDecimal(150));

        var item3FromInvoice = invoice.getItems().get(2);
        assertEquals(item3FromInvoice.getProduct(), product2);
        assertEquals(item3FromInvoice.getPrice(), new BigDecimal(100));
        assertEquals(item3FromInvoice.getQuantity(), 7);
        assertEquals(item3FromInvoice.getValue(), new BigDecimal(700));

        try {
            //CleanUp
            invoiceDao.deleteById(id);
        } catch (Exception e) {
            //do nothing
        }
    }
}
