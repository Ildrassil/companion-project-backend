package model

import model.submodel.MainCategory

class Recipe {
    String id
    String name
    String shortDescription
    String description
    RecipeIngredient[] recipeIngredients
    Category[] categories
    MainCategory mainCategory
}

