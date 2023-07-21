package Website;

import Components.Category.Category;
import Components.Coupon.Coupon;
import Components.Customer.Customer;
import Components.Order.Order;
import Components.Product.Product;
import Components.Product.ProductComponents.Tag;
import Components.ProductAttribute.ProductAttribute;
import Exceptions.BadHTTPResponseException;
import Exceptions.FetchException;
import GUI.Panes.CategoryListPane;
import Lists.PaginatedQueryList;
import Lists.QueryList;
import Lists.UnpaginatedQueryList;
import REST.RESTConnection;
import REST.RESTEndpoints;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Website implements Serializable {

    private String name;
    private String stringUrl;
    private User user;


    public Website(String name, String url, User user) throws URISyntaxException {

        if(url.matches("^(https|http)://[a-zA-Z]+(.[a-zA-Z]+)+$")) {
            this.stringUrl = url + "/";
        } else {
            throw new URISyntaxException(url, "URL has to start with http:// or https:// and end with .xxx");
        }

        this.name = name;
        this.user = user;

        System.out.println("done");
    }

    public String getName() {
        return name;
    }
    public String getUrl() {
        return stringUrl;
    }

    public PaginatedQueryList<Product> getProducts() throws FetchException, BadHTTPResponseException {

        RESTConnection connection = new RESTConnection(stringUrl, user);

        return new PaginatedQueryList<>(connection, RESTEndpoints.getProductsEndpoint(), Product.class);
    }

    public QueryList<Product> getAllProducts() throws FetchException, BadHTTPResponseException {

        RESTConnection connection = new RESTConnection(stringUrl, user);

        return new UnpaginatedQueryList<>(connection, RESTEndpoints.getProductsEndpoint(), Product.class);
    }

    public QueryList<Coupon> getCoupons() throws FetchException {

        RESTConnection connection = new RESTConnection(stringUrl, user);

        CompletableFuture<PaginatedQueryList<Coupon>> listFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return new PaginatedQueryList<>(connection, RESTEndpoints.getCouponsEndpoint(), Coupon.class) {
                };
            } catch (BadHTTPResponseException e) {
                System.out.println("Fuck"); // TODO Exception
                return null;
            }
        });


        try {
            if(listFuture.get() == null) {
                throw new FetchException("Could not complete request");
            }
            return listFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new FetchException(e.getMessage());
        }
    }

    public QueryList<Customer> getCustomers() throws FetchException {

        RESTConnection connection = new RESTConnection(stringUrl, user);

        CompletableFuture<PaginatedQueryList<Customer>> listFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return new PaginatedQueryList<>(connection, RESTEndpoints.getCustomersEndpoint(), Customer.class) {
                };
            } catch (BadHTTPResponseException e) {
                System.out.println("Fuck");
                return null;
            }
        });

        try {
            if(listFuture.get() == null) {
                throw new FetchException("Could not complete request");
            }
            return listFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new FetchException(e.getMessage());
        }
    }

    public QueryList<Order> getOrders() throws FetchException {

        RESTConnection connection = new RESTConnection(stringUrl, user);

        CompletableFuture<PaginatedQueryList<Order>> listFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return new PaginatedQueryList<>(connection, RESTEndpoints.getOrdersEndpoint(), Order.class) {
                };
            } catch (BadHTTPResponseException e) {
                System.out.println("Fuck"); // TODO Exception
                return null;
            }
        });

        try {
            if(listFuture.get() == null) {
                throw new FetchException("Could not complete request");
            }
            return listFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new FetchException(e.getMessage());
        }
    }

    public QueryList<Tag> getTags() throws FetchException {

        RESTConnection connection = new RESTConnection(stringUrl, user);

        CompletableFuture<PaginatedQueryList<Tag>> listFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return new PaginatedQueryList<>(connection, RESTEndpoints.getProductTagsEndpoint(), Tag.class) {
                };
            } catch (BadHTTPResponseException e) {
                System.out.println("Fuck"); // TODO Exception
                return null;
            }
        });

        try {
            if(listFuture.get() == null) {
                throw new FetchException("Could not complete request");
            }
            return listFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new FetchException(e.getMessage());
        }
    }

    public QueryList<Category> getCategories() throws FetchException {

        RESTConnection connection = new RESTConnection(stringUrl, user);

        CompletableFuture<PaginatedQueryList<Category>> listFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return new PaginatedQueryList<>(connection, RESTEndpoints.getProductCategoriesEndpoint(), Category.class) {
                };
            } catch (BadHTTPResponseException e) {
                System.out.println("Fuck"); // TODO Exception
                return null;
            }
        });

        try {
            if(listFuture.get() == null) {
                throw new FetchException("Could not complete request");
            }
            return listFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new FetchException(e.getMessage());
        }
    }

    public QueryList<ProductAttribute> getProductAttributes() throws FetchException {

        RESTConnection connection = new RESTConnection(stringUrl, user);

        CompletableFuture<PaginatedQueryList<ProductAttribute>> listFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return new PaginatedQueryList<>(connection, RESTEndpoints.getProductAttributesEndpoint(), ProductAttribute.class) {
                };
            } catch (BadHTTPResponseException e) {
                System.out.println("Fuck"); //TODO Exception
                return null;
            }
        });

        try {
            if(listFuture.get() == null) {
                throw new FetchException("Could not complete request");
            }
            return listFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new FetchException(e.getMessage());
        }
    }

    //TODO implement endpoint
/*
    public QueryList<ProductAttributeTerm> getProductAttributeTerm() throws FetchException {

        RESTConnection connection = new RESTConnection(stringUrl, user);

        CompletableFuture<PaginatedQueryList<ProductAttributeTerm>> listFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return new PaginatedQueryList<>(connection, RESTEndpoints.getProdu(), ProductAttributeTerm.class) {
                };
            } catch (BadHTTPResponseException e) {
                System.out.println("Fuck");
                return null;
            }
        });

        try {
            if(listFuture.get() == null) {
                throw new FetchException("Could not complete request");
            }
            return listFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new FetchException(e.getMessage());
        }
    }*/
}
