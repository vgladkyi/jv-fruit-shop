package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int oldQuantity = Storage.fruits.get(transaction.getFruit());
        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + transaction.getFruit());
        } else {
            Storage.fruits.put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
        }
    }
}