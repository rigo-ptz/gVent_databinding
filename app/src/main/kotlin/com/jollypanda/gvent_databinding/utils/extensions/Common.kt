package com.jollypanda.gvent_databinding.utils.extensions

/**
 * @author Yamushev Igor
 * @since  18.08.17
 */
fun retrofit2.HttpException.getDetailedInfo(): String {
    // конвертим тут ошибочный ответ, если надо
    return "Ошибочка вышла"
}