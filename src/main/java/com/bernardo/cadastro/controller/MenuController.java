package com.bernardo.cadastro.controller;

import com.bernardo.cadastro.dto.MenuDto;
import com.bernardo.cadastro.model.Menu;
import com.bernardo.cadastro.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/insert")
    public ResponseEntity insertMenu(@RequestBody MenuDto menuDto){
        try {
            Menu menu = menuService.insertMenu(menuDto);
            return ResponseEntity.ok(menu);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMenu(@RequestBody MenuDto menuDto, @PathVariable("id") Long id) {
        Menu menu = Menu.create(menuDto);
        menu.setId(id);
        Menu updateMenu = menuService.updateMenu(menu);

        return Objects.nonNull(updateMenu)? ResponseEntity.ok(updateMenu) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity deleteMenu(Long id) {
        return menuService.deleteMenu(id)?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Optional<Menu> menu = menuService.findById(id);

        return menu.isPresent() ? ResponseEntity.ok(menu.get()) : ResponseEntity.notFound().build();

    }

}
