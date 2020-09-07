package search;

import java.util.Optional;

public interface Tree {
    void insert(int value);

    Optional<Node> search(int value);

    Optional<Node> delete(int value);
}
