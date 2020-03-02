package entities.lendicoService.alphavantage;

import entities.lendicoService.BaseResponse;

public class QuoteEndPointResponse extends BaseResponse{

	private BestMatches[] bestMatches;

	public BestMatches[] getBestMatches() {
		return bestMatches;
	}

	public void setBestMatches(BestMatches[] bestMatches) {
		this.bestMatches = bestMatches;
	}

	
	

}
