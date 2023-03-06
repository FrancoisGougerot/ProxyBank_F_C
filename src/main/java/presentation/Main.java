package presentation;

import entity.Client;

import static persistance.client.FindClientById.findClientById;
import static persistance.client.RemoveClientById.removeClientById;
import static persistance.compte.FindAccountByClientId.findAccountByClientId;
import static persistance.compte.FindAccountById.findAccountById;
import static persistance.compte.RemoveAccountById.removeAccountById;

public class Main {
	public static void main(String[] args) {
		findClientById(1);
		removeClientById(1);
		findAccountByClientId(1);
		findAccountById(1);
		removeAccountById(1);
	}
}