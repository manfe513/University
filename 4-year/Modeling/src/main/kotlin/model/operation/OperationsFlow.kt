package model.operation

/**
 * Процессы, состоящие из отдельных упорядоченных операций
 */
object OperationsFlow {

    // создание стеклопакета
    val glassCreation = listOf(
        CutGlassOperation,
        MakeGlassFrameOperation,
        DryGlassPocketOperation
    )

    // создание профиля для оконной конструкции
    val profileCreation = listOf(
        CutProfileOperation,
        CutAmplifierOperation,
        WeldingOperation,
        CleanOperation,
        SetDetailsOperation,
        FinishWindowOperation
    )
}