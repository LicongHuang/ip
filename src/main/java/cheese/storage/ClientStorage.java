package cheese.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDate;

import cheese.task.Task;
import cheese.parser.Parser;
import cheese.policy.Policy;
import cheese.client.Client;
import cheese.clientlist.ClientList;
/**
 * Storage class that handles the loading and saving of client information
 *
 */

public class ClientStorage{
  private File file;
  private ClientList clientList;
  private Parser parser;

  public ClientStorage(String filePath) {
    this.file = new File(filePath);
    if (!this.file.exists()) {
      try {
        this.file.createNewFile();
        System.out.println("File created: " + this.file.getName());
      } catch (IOException e) {
        System.out.println("Something went wrong: " + e.getMessage());
      }
    }
    this.clientList = new ClientList();
    this.parser = new Parser();

  }

  /**
   * Loads the clients from the file and returns a ClientList object
   * @return ClientList object
   */
  public ClientList loadClient(){
    try{
      Scanner sc = new Scanner(this.file);
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] splitLine = line.split("|");
        String name = splitLine[0].trim();
        String address = splitLine[3].trim();
        String phone = splitLine[2].trim();
        String email = splitLine[1].trim();
        LocalDate birthDate = LocalDate.parse(splitLine[4].trim());
        String policy = splitLine[5].trim();
        Client client = new Client(name, address, phone, email, birthDate);
        this.clientList.addClient(client);
        String[] splitPolicy = policy.split(",");
        for (String p : splitPolicy) {
          client.addPolicy(this.parser.parsePolicy(p));
        }
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + e.getMessage());
    } 
    return this.clientList;
  }

  /**
   * Saves the clients in the ClientList object to the file
   * @param clientList ClientList object
   */

  public void saveClient(ClientList clientList) {
    try {
      FileWriter fw = new FileWriter(this.file);

      for (Client client : clientList.getClients()) {
        String policyString = "";
        for (Policy policy : client.getPolicies()) {
          policyString = policyString + policy.toString();
        }
        fw.write(client.getName() + "|" + client.getEmail() + "|" + client.getPhone() + "|" + client.getAddress() + "|" + client.getBirthDate() + "|" + policyString);
        fw.write("\n");
      }
      fw.close();
    } catch (IOException e) {
      System.out.println("Something went wrong: " + e.getMessage());
    }
  }
}
