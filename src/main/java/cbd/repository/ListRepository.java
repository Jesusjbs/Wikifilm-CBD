package cbd.repository;

import java.util.List;

import cbd.model.Lista;

public class ListRepository {

	public List<Lista> getLists(String accountId, String sessionId) {
		return null;
	}

	public Lista createList(String aToken, String title) {
		return null;
	}

	public void deleteList(String aToken, Integer listId) {
	}

	public void updateList(String aToken, Integer listId, String description, String nombre, Boolean tipo) {
	}

	public List<Lista> getListById(String aToken, Integer listId) {
		return null;
	}

	public void addItem(String aToken, Integer listId, Integer itemId, String tipo) {
	}

	public void deleteItem(String aToken, Integer idList, Integer idItem) {
	}
}
