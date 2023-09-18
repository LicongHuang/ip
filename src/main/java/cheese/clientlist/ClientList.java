package cheese.clientlist;

import java.util.ArrayList;
import java.util.List;

import cheese.client.Client;


public class ClientList {
  private List<Client> clients;
  
  public ClientList() {
    clients = new ArrayList<Client>();
  }
  
  public void addClient(Client client) {
    clients.add(client);
  }
  
  public void removeClient(Client client) {
    clients.remove(client);
  }
  
  public List<Client> getClients() {
    return clients;
  }
  
  public Client getClient(String name) {
    for (Client client : clients) {
      if (client.getName().equals(name)) {
        return client;
      }
    }
    return null;
  }

  public Client getClient(int index) {
    return clients.get(index);
  }
  
  public boolean containsClient(String name) {
    for (Client client : clients) {
      if (client.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }
  
  public int getSize() {
    return clients.size();
  }
}
