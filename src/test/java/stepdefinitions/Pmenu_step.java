package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.Pmenu_page;

public class Pmenu_step {
	
	@Then("Admin should not have any broken links for Program module")
	public void admin_should_not_have_any_broken_links_for_program_module() {
	    
		Pmenu_page.getInstance().Brokenlinkverify();
	}

}
