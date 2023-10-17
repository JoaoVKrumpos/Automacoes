package Tests;

import Model.Lead;
import Pages.LeadPage;
import io.restassured.response.Response;
import logging.LoggerUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeadTest extends BaseTest {

    leadPage = new LeadPage(apikey);
    @Before

    public void setUp() {
        String apikey = "e040aff85b261d19dc422d83de5f7faa7e4a78d4";
        leadPage = new LeadPage(apikey);

    }

    @Test
    public void testGetAllleads() {
        Response response = leadPage.getAllLeads();
        Assert.assertEquals(200, response.getStatusCode());
        LoggerUtil.info("Chamada para obter todos os leads ");

    }

    @Test
    public void testGetLeadById() {
        Response response = leadPage.getLeadById(30781971);
        Assert.assertEquals(200, response.getStatusCode());
        LoggerUtil.info("Chamada para obter lead específico");

    }

    @Test
    public void testCreateLead() {
        Lead lead = new Lead();
        lead.setFirstName("jhon da cruz ");
        lead.setLastName("cruzzz");
        lead.setEmail("joao.victor@out.com");
        lead.setCompany("diretormd");
        lead.setPosition("ti");

        LoggerUtil.info("Criandolead ");

    }

    @Test
    public void testUpdateLead() {
        int leadID = 130781971;
        Lead lead = new Lead();
        lead.setEmail("joao.victor.update.u@update.com");
        lead.setFirstName("jhonUpdate");
        LoggerUtil.info("Atualizando leads  ");
    }


    @Test
    public void testDeleteLead() {
        int leadID = 130781971;
        Response response = leadPage.DeleteLead(leadID);

    }
}