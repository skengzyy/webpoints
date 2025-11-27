package at.ac.tgm.controller;

import at.ac.tgm.dto.GroceryItemDto;
import at.ac.tgm.service.GroceryListService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grocery")
public class GroceryListController {
    private final GroceryListService groceryListService;

    public GroceryListController(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @GetMapping
    public ResponseEntity<List<GroceryItemDto>> getAllGroceryItems() {
        List<GroceryItemDto> items = groceryListService.getGroceryItems();
        if (items.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItemDto> getGroceryItemById(@PathVariable Long id) {
        Optional<GroceryItemDto> optionalItem = groceryListService.getGroceryItem(id);
        if (optionalItem.isPresent()) return ResponseEntity.ok(optionalItem.get());
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteGroceryItems() {
        groceryListService.deleteGroceryItem(null);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItemById(@PathVariable Long id) {
        groceryListService.deleteGroceryItem(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<GroceryItemDto> createGroceryItem(@Valid @RequestBody GroceryItemDto newItem) {
        if (newItem.getId() != null) {
            throw new IllegalArgumentException("id muss null sein");
        }
        GroceryItemDto savedItem = groceryListService.createGroceryItem(newItem);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedItem.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedItem);
    }

    @PutMapping
    public ResponseEntity<GroceryItemDto> updateGroceryItem(@Valid @RequestBody GroceryItemDto itemToUpdate) {
        if (itemToUpdate.getId() == null) {
            throw new IllegalArgumentException("id darf nicht null sein");
        }
        GroceryItemDto updatedItem = groceryListService.updateGroceryItem(itemToUpdate);
        return ResponseEntity.ok(updatedItem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GroceryItemDto> patchGroceryItem(@PathVariable Long id, @RequestParam boolean collected) {
        GroceryItemDto patchedItem = groceryListService.patchGroceryItem(id, collected);
        return ResponseEntity.ok(patchedItem);
    }
}
