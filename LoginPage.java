package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@type,'text')]")
	private WebElement Username;

	@FindBy(xpath = "//input[contains(@type,'password')]")
	private WebElement password;

	@FindBy(xpath = "//input[contains(@name,'submit')]")
	private WebElement login;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername() {
		return Username;
	}

	public void setUsername(WebElement username) {
		Username = username;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLogin() {
		return login;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String GetUrl() {
		String URL = driver.getCurrentUrl();
		return URL;

	}
	public void UsernameSendkey(String user) {
		Username.sendKeys(user);
	}
	public void Passwordsendkeys(String pass) {
		password.sendKeys(pass);
	}
	public Homepage ClickonLoginButton() {
		login.click();
		return new Homepage(driver);
	}
}