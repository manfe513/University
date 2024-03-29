package model

/**
 * Перечисление определяет множество допустимых "ресурсов",
 * которые требуются для выполнения различных операций
 */
enum class Resource {
    WORKER, // человек, рабочий
    STAND, // стенд для работы
    MACHINE_THIN_CUT, // узкорезный станок
    MACHINE_METAL_CUT, // металлорежущий станок
    MACHINE_WELDING // сварочная машина
}