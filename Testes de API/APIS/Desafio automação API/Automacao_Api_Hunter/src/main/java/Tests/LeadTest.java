package Tests;

import Model.Lead;
import Pages.LeadPage;
import io.restassured.response.Response;
import logging.LoggerUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeadTest extends BaseTest {

private String apikey = "e040aff85b261d19dc422d83de5f7faa7e4a78d4";

    @Before

    public void setUp() {


    }

    @Test
    public void testGetAllleads() {
        LeadPage leadPage = new LeadPage(apikey);
        Response response = leadPage.getAllLeads();
        Assert.assertEquals(200, response.getStatusCode());
        LoggerUtil.info("Chamada para obter todos os leads ");

    }

    @Test
    public void testGetLeadById() {
        LeadPage leadPage = new LeadPage(apikey);
        Response response = leadPage.getLeadById(30781971);
        Assert.assertEquals(200, response.getStatusCode());
        LoggerUtil.info("Chamada para obter lead específico");

    }

    @Test
    public void testCreateLead() {
        LeadPage leadPage = new LeadPage(apikey);
        Lead lead = new Lead();
        lead.setFirstName("jhon da cruz ");
        lead.setLastName("cruzzz");
        lead.setEmail("joao.victor@out.com");
        lead.setCompany("diretormd");
        lead.setPosition("ti");
        leadPage.createLead(lead);
        LoggerUtil.info("Criandolead ");

    }

    @Test
    public void testUpdateLead() {
        LeadPage leadPage = new LeadPage(apikey);
        int leadID = 130781971;
        Lead lead = new Lead();
        lead.setEmail("joao.victor.update.u@update.com");
        lead.setFirstName("jhonUpdate");
        leadPage.updateLead(130781971,lead);
        LoggerUtil.info("Atualizando leads ");
    }


    @Test
    public void testDeleteLead() {
        LeadPage leadPage = new LeadPage(apikey);
        int leadID = 130781971;
        Response response = leadPage.DeleteLead(leadID);
        response.getStatusCode();

    }
}