package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Recipe recipe1 = new Recipe();

        Set<Recipe> recipesMock = new HashSet<>();
        recipesMock.add(recipe1);
        when(recipeService.getRecipes()).thenReturn(recipesMock);
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1,recipes.size());
        final Iterable<Recipe> all = verify(recipeRepository, times(1)).findAll();
    }
}