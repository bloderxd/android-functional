package bloder.com.usecase.albums

import arrow.Kind
import arrow.core.EitherOf
import arrow.core.EitherPartialOf
import bloder.com.usecase.UseCase

private typealias Albums = List<String>

interface FetchAlbumsUseCase : UseCase<EitherPartialOf<Nothing>, Albums> {

    override suspend fun execute(): Kind<EitherPartialOf<Nothing>, Albums>
}

fun fetchAlbumsUseCase(execute: suspend () -> EitherOf<Nothing, Albums>): FetchAlbumsUseCase = object : FetchAlbumsUseCase {
    override suspend fun execute(): EitherOf<Nothing, Albums> = execute()
}