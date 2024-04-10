package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ProductDao productDao;

    private Product product1;
    private Product product2;
    private Item item1;
    private Item item2;
    private Invoice invoice;

    @BeforeEach
    void setUp() {
        product1 = new Product("Product1");
        product2 = new Product("Product2");

        item1 = new Item(product1, new BigDecimal("100"), 2);
        item2 = new Item(product2, new BigDecimal("50"), 3);

        invoice = new Invoice("FV1");
        invoice.addItems(item1);
        invoice.addItems(item2);
    }

    @AfterEach
    void tearDown() {
        invoiceDao.deleteAll();
        itemDao.deleteAll();
        productDao.deleteAll();
    }

    @Test
    void testInvoiceDaoSave() {
        // Given
        productDao.save(product1);
        productDao.save(product2);

        // When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        // Then
        assertNotNull(invoiceId);

        // CleanUp
        invoiceDao.deleteById(invoiceId);
    }
}
