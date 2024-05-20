package companion

import grails.rest.RestfulController



class RecipeController extends RestfulController{

   RecipeController(){
       super(Recipe)
   }

}
