package com.bernardo.cadastro.service;

import com.bernardo.cadastro.dto.MenuDto;
import com.bernardo.cadastro.model.Menu;
import com.bernardo.cadastro.model.Restaurant;
import com.bernardo.cadastro.repository.MenuRepository;
import com.bernardo.cadastro.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Menu insertMenu(MenuDto menuDto) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(menuDto.getRestaurant());
        if (restaurant.isPresent()){
            Menu menu = Menu.create(menuDto);
            menu.setRestaurant(restaurant.get());

            return menuRepository.save(menu);

        }else {
            return null;
        }

    }

    public Menu updateMenu(Menu menu) {
        Optional<Menu> newMenu = menuRepository.findById(menu.getId());
        if (newMenu.isPresent()){
            return menuRepository.save(menu);
        }else {
            return null;
        }

    }

    public boolean deleteMenu(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isPresent()){
            menuRepository.delete(menu.get());
            return true;
        }else {
            return false;
        }
    }

    public Optional<Menu> findById(Long id) {

        return  menuRepository.findById(id);
    }


}
