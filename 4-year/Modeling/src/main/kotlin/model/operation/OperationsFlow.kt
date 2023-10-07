package model.operation

object OperationsFlow {

    val glassCreation = listOf(
        CutGlassOperation,
        MakeGlassFrameOperation,
        DryGlassPocketOperation
    )

    val windowCreation = listOf(
        CutProfileOperation,
        CutAmplifierOperation,
        WeldingOperation,
        CleanOperation,
        SetDetailsOperation,
        FinishWindowOperation
    )
}