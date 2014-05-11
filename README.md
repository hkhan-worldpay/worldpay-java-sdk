Worldpay REST API Java SDK
=====================

Java SDK for interacting with the Worldpay Developer REST API.

## Usage

Initialize by providing the service key and then use the required service:
```java	
	WorldpayGateway worldpay = new WorldpayGateway("YOUR_SERVICE_KEY");
	
	OrderRequest orderRequest = new OrderRequest();
	orderRequest.setSingleUseToken("valid-token");
	orderRequest.setAmount(1999);
	orderRequest.setCurrencyCode(CurrencyCode.GBP);
	orderRequest.setName("test name");
	orderRequest.setOrderDescription("test description");
	
	try {
	    OrderResponse orderResponse = worldpay.order().create(orderRequest);
	    System.out.println("Order code: " + orderResponse.getOrderCode());
	} catch (WorldpayException wpe) {
	    System.out.println("Error code: " + wpe.getError().getCustomCode());
	    System.out.println("Error description: " + wpe.getError().getDescription());
	    System.out.println("Error message: " + wpe.getError().getMessage());
	}
```
