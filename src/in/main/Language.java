package in.main;

public class Language {

	String[] languages = { "English", "Hindi", "Spanish", "German", "Arabic" };
	String selectedLanguage;

	// Method to get the language catalog
	public String getLanguageCatalog() {
		StringBuilder catalog = new StringBuilder();
		catalog.append("[");
		for (int i = 0; i < languages.length; i++) {
			catalog.append(i + " - " + languages[i] + ",  ");
		}
		catalog.append("]");
		return catalog.toString();
	}

	// Method to set language
	public void selectLanguage(int language) {
		this.selectedLanguage = languages[language];
	}

	// Method to get the selected language
	public String getSelectedLanguage() {
		return this.selectedLanguage;
	}

}
