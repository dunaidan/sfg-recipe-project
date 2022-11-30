package guru.springframework.sfgrecipeproject.bootstrap;

import guru.springframework.sfgrecipeproject.domain.*;
import guru.springframework.sfgrecipeproject.repository.*;
import guru.springframework.sfgrecipeproject.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final RecipeService recipeService;
    private final IngredientRepository ingredientRepository;
    private final IngredientQuantityRepository ingredientQuantityRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final NotesRepository notesRepository;

    public DataLoader(RecipeService recipeService, IngredientRepository ingredientRepository, IngredientQuantityRepository ingredientQuantityRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, NotesRepository notesRepository) {
        this.recipeService = recipeService;
        this.ingredientRepository = ingredientRepository;
        this.ingredientQuantityRepository = ingredientQuantityRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.notesRepository = notesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category mexican = categoryRepository.findByDescription("Mexican").get();
        Category fastFood = categoryRepository.findByDescription("Fast Food").get();
        Category american = categoryRepository.findByDescription("American").get();
        Category italian = categoryRepository.findByDescription("Italian").get();

        Ingredient avocado = new Ingredient("Avocado");
        ingredientRepository.save(avocado);
        Ingredient salt = new Ingredient("Salt");
        ingredientRepository.save(salt);
        Ingredient freshLime = new Ingredient("Fresh Lime");
        ingredientRepository.save(freshLime);
        Ingredient redOnion = new Ingredient("Red Onion");
        ingredientRepository.save(redOnion);
        Ingredient serranoChilis = new Ingredient("Serrano Chilis");
        ingredientRepository.save(serranoChilis);
        Ingredient cilantro = new Ingredient("Cilantro");
        ingredientRepository.save(cilantro);
        Ingredient blackPepper = new Ingredient("Black Pepper");
        ingredientRepository.save(blackPepper);
        Ingredient ripeTomato = new Ingredient("Ripe Tomato");
        ingredientRepository.save(ripeTomato);
        Ingredient redRadish = new Ingredient("Red Radish");
        ingredientRepository.save(redRadish);
        Ingredient tortillaChips = new Ingredient("Tortilla Chips");
        ingredientRepository.save(tortillaChips);

        UnitOfMeasure pieces = unitOfMeasureRepository.findByName("Pieces").get();
        UnitOfMeasure piece = unitOfMeasureRepository.findByName("Piece").get();
        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByName("Teaspoon").get();
        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByName("Tablespoon").get();
        UnitOfMeasure cup = unitOfMeasureRepository.findByName("Cup").get();
        UnitOfMeasure pinch = unitOfMeasureRepository.findByName("Pinch").get();
        UnitOfMeasure ounce = unitOfMeasureRepository.findByName("Ounce").get();


        Recipe guacamole = new Recipe();
        guacamole.setTitle("How to Make the Best Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(10);
        guacamole.setServings(4);
        guacamole.setSource("Simple Recipes");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.getCategories().add(mexican);
        guacamole.getCategories().add(fastFood);
        guacamole.setDifficulty(Difficulty.EASY);

        IngredientQuantity avocadoQuantity = new IngredientQuantity(avocado, new BigDecimal(2), pieces, guacamole);
        IngredientQuantity saltQuantity = new IngredientQuantity(salt, new BigDecimal("0.25"), teaspoon, guacamole);
        IngredientQuantity freshLimeQuantity = new IngredientQuantity(freshLime, new BigDecimal(1), tablespoon, guacamole);
        IngredientQuantity redOnionQuantity = new IngredientQuantity(redOnion, new BigDecimal(2), pieces, guacamole);
        IngredientQuantity serranoChilisQuantity = new IngredientQuantity(serranoChilis, new BigDecimal(2), pieces, guacamole);
        IngredientQuantity cilantroQuantity = new IngredientQuantity(cilantro, new BigDecimal(2), tablespoon, guacamole);
        IngredientQuantity blackPepperQuantity = new IngredientQuantity(blackPepper, new BigDecimal(1), pinch, guacamole);
        IngredientQuantity ripeTomatoQuantity = new IngredientQuantity(ripeTomato, new BigDecimal(1), piece, guacamole);
        IngredientQuantity redRadishQuantity = new IngredientQuantity(redRadish, new BigDecimal(4), pieces, guacamole);
        IngredientQuantity tortillaChipsQuantity = new IngredientQuantity(tortillaChips, new BigDecimal(4), pieces, guacamole);


        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Guacamole! Did you know that over 2 billion pounds of avocados are consumed each year in the U.S.? (Google it.) That's over 7 pounds per person. I'm guessing that most of those avocados go into what has become America's favorite dip: guacamole.");
        guacamole.addNotes(guacamoleNotes);

        guacamole.setDirections("<p>The best guacamole keeps it simple: just ripe avocados and a handful of flavorful mix-ins. " +
                "Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.</p>" +
                "<p><strong>1. Cut the avocado:</strong></p>" +
                "<p>Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. Place in a bowl.</p>" +
                "<p><strong>2. Mash the avocado flesh:</strong></p>" +
                "<p>Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)</p>" +
                "<p><strong>3. Add the remaining ingredients to taste:</strong></p>" +
                "<p>Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.</p>" +
                "<p>Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. " +
                "So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.</p>" +
                "<p>Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.</p>" +
                "<p><strong>4. Serve immediately:</strong></p>" +
                "<p>If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. " +
                "(The oxygen in the air causes oxidation which will turn the guacamole brown.)</p>" +
                "<p>Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.</p>" +
                "<p>Refrigerate leftover guacamole up to 3 days.</p>" +
                "<p>Note: Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving.</p>");

        recipeService.save(guacamole);


    }
}
