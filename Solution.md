# SuperHeroApp
Coding Challenge for HireUp

Steps to run the code. 
1. Run the server
2. Check your Macs/Windows ip address
3. Go to RetroFitModule line 19 and change the ip address to your Machine's ip address
   http://192.168.0.100:1337/ > http://<your machine's ip address>:1337
4. Run the app. 

Overview:
I have used MVVM along with repository pattern. I have created a single activity fragments, though
I have the option to use compose way to structure the code but for the purpose of the extending the 
app I opted for the single activity hosting fragments. Furthermore, I have used Compose navigation, 
and the whole app is written in Jetpack compose. I have tried to make UI reusable by making smaller 
components which has low coupling and high cohesion. All the components have KDocs for explanation.

Dependencies:
I have used following libraries
1. Coil - for rendering images
2. Hilt - dependency injection
3. Retrofit - network calls
4. Compose libraries
Apart from retrofit all the libraries are from google. 

Screenshots:
I have placed all screenshots in the folder - "Screenshots"

Challenges:
1. Getting the right base url was a challenge, since I was primarily using Emulator for testing I 
was not able to hit the endpoint with localhost so I figured I had to use my Mac's IP address to 
connect with the Server. I have mentioned this in the RetrofitModule.kt
2. Getting all the libraries working together was a challenge as well, as coil's latest library
wasn't working with the older gradle version despite having compatibility and then there were some 
bugs in the latest android sdk libraries as well. So I had to give it sometime to get all the 
dependencies work nicely with each other.

Improvements:
If I had more time I would have done few things better.
1. I would have used Redux pattern instead of MVVM, compose is functional and it works best with
state management (MVI etc.)
2. I would have spent more time on writing better unit tests
3. I would have added Room db to persist data and to have minimal reliance on network calls
4. I would have made the architecture better (navigation should have been responsibility of the 
parent rather than individual fragments)

Part 2:
Favourites:
If making super hero favourite supported by library I would create a button on Detailed view 
(SuperheroDetailScreen) which basically would have called a viewModel method i.e 
"setFavouriteSuperHero" taking super hero's id. Visually favourite superhero would have a star 
indicating the favourite state.
Change in components (Star)> SuperheroDetailScreen > SuperheroViewModel > SuperHeroApi  

Favourite List Item:
I would have made changes to SuperheroItemView to have a star icon
Fetching favourites data from the endpoint and inserting into the Room DB and establishing one to one 
relationship between favourites and superheros and then fetching combined data to show on the 
superhero list. 

Search favourites/all:
Adding a checkbox (favourites) under search bar. Updating SearchView components 
(ui>components). This checkbox value be saved in SharedPreferences so that even if the user relaunches
app they would still see their last selection. Since searching for favourites does not have 
server-level implication tracking its value locally is fine. 
This SharedPreferences would be accessed in repository and when user searches for super hero only
super heroes appear whom have been favourite(d) before. When checkbox state changes, LiveData
(isFavourite) changes which is observed in SuperHeroListScreen and SharedPreference value changes
and DB is queried to get all favourite super heroes only.

Persisting Favourites:
Favourite checkbox state is saved in SharedPreferences, but if the user has made a search when then 
searched term is also saved in the SharedPreferences. If the user relaunches app then searched term
and favourite status is taken from SharedPreferences and Db is queried to get the results based on 
both these values. As mentioned above I would have Room DB with two tables, one for favourite super 
hero ids and one table for all the super heroes. When the user wants to see only favourites then 
checking values from both the tables I would get the favourites (relations, compound table, etc.)