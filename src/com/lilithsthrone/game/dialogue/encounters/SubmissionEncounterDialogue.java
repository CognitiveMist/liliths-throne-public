package com.lilithsthrone.game.dialogue.encounters;

import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.item.AbstractItem;
import com.lilithsthrone.main.Main;

/**
 * @since 0.2.1
 * @version 0.3.7.3
 * @author Innoxia
 */
public class SubmissionEncounterDialogue {

	public static final DialogueNode FIND_ITEM = new DialogueNode("Rubbish Pile", "", true) {
		@Override
		public int getSecondsPassed() {
			return 2*60;
		}
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/submission/submissionPlaces", "FIND_ITEM")
					+ "<p style='text-align:center;'>"
						+ "<b>"
						+ AbstractEncounter.getRandomItem().getDisplayName(true)
						+ "</b>"
					+ "</p>";
		}
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Take", "Add the " + AbstractEncounter.getRandomItem().getName() + " to your inventory.", Main.game.getDefaultDialogue(false)){
					@Override
					public void effects() {
						Main.game.getTextStartStringBuilder().append(Main.game.getPlayer().addItem((AbstractItem) AbstractEncounter.getRandomItem(), true, true));
					}
				};
				
			} else if (index == 2) {
				return new Response("Leave", "Leave the " + AbstractEncounter.getRandomItem().getName() + " on the floor.", Main.game.getDefaultDialogue(false));
				
			} else {
				return null;
			}
		}
	};

	public static final DialogueNode FIND_CLOTHING = new DialogueNode("Rubbish Pile", "", true) {
		@Override
		public int getSecondsPassed() {
			return 2*60;
		}
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/submission/submissionPlaces", "FIND_ITEM")
					+ "<p style='text-align:center;'>"
					+ "<b>"
					+ AbstractEncounter.getRandomItem().getDisplayName(true)
					+ "</b>"
					+ "</p>";
		}
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Take", "Add the " + AbstractEncounter.getRandomItem().getName() + " to your inventory.", Main.game.getDefaultDialogue(false)){
					@Override
					public void effects() {
						Main.game.getTextStartStringBuilder().append(Main.game.getPlayer().addClothing((AbstractClothing) AbstractEncounter.getRandomItem(), 1, true, true));
					}
				};

			} else if (index == 2) {
				return new Response("Leave", "Leave the " + AbstractEncounter.getRandomItem().getName() + " on the floor.", Main.game.getDefaultDialogue(false));

			} else {
				return null;
			}
		}
	};

	public static final DialogueNode FIND_CLOTHING_EQUIPPED = new DialogueNode("Rubbish Pile", "", true) {
		@Override
		public int getSecondsPassed() {
			return 2*60;
		}
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/submission/submissionPlaces", "FIND_ITEM_EQUIPPED")
					+ "<p style='text-align:center;'>"
					+ "<b>"
					+ AbstractEncounter.getRandomItem().getDisplayName(true)
					+ "</b>"
					+ "</p>";
		}
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("[style.italicsBad(Oh no!)]", "Hopefully the " + AbstractEncounter.getRandomItem().getName() + " doesn't have any dangerous enchantments...", Main.game.getDefaultDialogue(false));

			} else {
				return null;
			}
		}
	};

	public static final DialogueNode FIND_CLOTHING_EQUIPPED_FAILED = new DialogueNode("Rubbish Pile", "", true) {
		@Override
		public int getSecondsPassed() {
			return 2*60;
		}
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/submission/submissionPlaces", "FIND_ITEM_EQUIPPED_FAILED")
					+ "<p style='text-align:center;'>"
					+ "<b>"
					+ AbstractEncounter.getRandomItem().getDisplayName(true)
					+ "</b>"
					+ "</p>";
		}
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Take item", "That " + AbstractEncounter.getRandomItem().getName() + " could have had some dangerous enchantments, I better get it off the streets!", Main.game.getDefaultDialogue(false)) {
					@Override
					public void effects() {
						Main.game.getTextStartStringBuilder().append(Main.game.getPlayer().addClothing((AbstractClothing) AbstractEncounter.getRandomItem(), 1, true, true));
					}
				};

			} else if (index == 2) {
				return new Response("Leave it behind", "Better let someone else deal with the " + AbstractEncounter.getRandomItem().getName() + ".", Main.game.getDefaultDialogue(false));

			} else {
				return null;
			}
		}
	};
}
