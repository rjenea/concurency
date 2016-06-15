package Optional_Lab_ExecutorService;

import java.util.Objects;

public class ExecutorServiceRequestResponse {

    public String host; //request
    public int port; //request
    public String response; //response

    public ExecutorServiceRequestResponse(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExecutorServiceRequestResponse) {
            ExecutorServiceRequestResponse lookup = (ExecutorServiceRequestResponse) obj;
            if (host.equals(lookup.host) && port == lookup.port) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.host);
        hash = 97 * hash + this.port;
        return hash;
    }
}