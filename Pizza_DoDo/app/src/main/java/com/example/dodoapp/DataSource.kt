package com.example.dodoapp

object DataSource {
    val list= arrayListOf(
        DoDoItem(ItemType.COMBO,1,"Комбо 2+1",
            " Купи 2 любые пиццы и еще 1 подарок. Цена комбо зависит от выбранных пицц и может быть увеличена",
            R.drawable.com3,
            4500),
        DoDoItem(ItemType.PIZZA,2,"Домашняя пицца",
            "Томатный соус, песто, мясо говядины, лук ",
            R.drawable.pio,
            2400),
        DoDoItem(ItemType.PIZZA,3,"Пепперони ",
            "Орегано, сыр, оливковое масло, сырокапченная колбаса",
            R.drawable.pepeob,
            2200),
        DoDoItem(ItemType.PIZZA,4,"Гавайская Пицца",
            "Пицца, приготовляемая с использованием белого соуса, сыра, ананасов, курицы и морепродуктов",
            R.drawable.piz4,
            4500),
        DoDoItem(ItemType.PIZZA,5,"Ветчина",
            "Свинина, вода, соль, сывороточный белок,сахар",
            R.drawable.vetchina,
            2000))
}