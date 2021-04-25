package doppio.apps.sociallist.controller;

import doppio.apps.authentication.model.User;
import doppio.apps.sociallist.model.BlockList;
import doppio.controller.AbstractController;
import doppio.event.AddToBlockedEvent;

public class SocialListController extends AbstractController {
    public void addToBlocked(AddToBlockedEvent event) {
        BlockList blockList = context.Blocklists.get(event.getBlocker().getBlockListId());
        blockList.getList().add(event.getBlocked().getId());
        context.Blocklists.update(blockList);
    }

    public void clearBlackListDB() {
        context.Blocklists.clear();
    }
}
