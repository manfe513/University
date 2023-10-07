package model

/**
 * Перечисление промежуточных продуктов
 */
enum class Product {

    GLASS_CUTTED, // нарезанное стекло
    GLASS_FRAME, // рамка
    GLASS_POCKET, // стеклопакет

    PROFILE_WORKPIECE, // заготовка профиля
    PROFILE_WITH_AMPLIFIER, // профиль с усилителем
    PROFILE_CONNECTED, // скреплённый профиль
    PROFILE_CLEANED, // зачищенный профиль
    PROFILE_DONE, // готовый профиль

    WINDOW_DONE // оконная конструкция (готовый продукт)
}