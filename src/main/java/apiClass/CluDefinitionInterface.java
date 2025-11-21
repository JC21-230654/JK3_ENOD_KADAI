package apiClass;

public interface CluDefinitionInterface {
	// モデルのデプロイ　→　予測 URL
	static final String apiUrl = "https://gyutan05.cognitiveservices.azure.com/language/:analyze-conversations?api-version=2024-11-15-preview";
	
	//　プロジェクト設定　→　 主キー:
	static final String subscriptionKey = "8d9aa09258e0455caf24868143940998";
	
	// プロジェクトを見る
	static final String projectName = "gyutan05";
	
	// モデルのデプロイを見る
	static final String deploymentName = "gyutanDeploy2";
}
