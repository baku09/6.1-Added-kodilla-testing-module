package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");

        Item item1 = new Item(product1, new BigDecimal("10.00"), 2);
        Item item2 = new Item(product2, new BigDecimal("20.00"), 4);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Invoice invoice = new Invoice("INVOICE_1", items);

        //When
        productDao.save(product1);
        productDao.save(product2);

        itemDao.save(item1);
        itemDao.save(item2);

        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        Assertions.assertEquals(1, invoiceDao.count());
        Assertions.assertEquals(2, itemDao.count());
        Assertions.assertEquals(2, productDao.count());

        //Clean up
        invoiceDao.deleteById(invoiceId);
        itemDao.deleteAll();
        productDao.deleteAll();

    }
}
