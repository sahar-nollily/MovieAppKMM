//
//  SwiftUIView.swift
//  iosApp
//
//  Created by Sa7ar Nollily on 12/07/1443 AH.
//  Copyright © 1443 orgName. All rights reserved.
//

import SwiftUI

@ViewBuilder private func getMovieListView() -> some View {
    List(){
        ForEach(self.movieListViewModel.movieListState.data, id: \.self.name){
            movie in
            if #available(iOS 15.0, *) {
                AsyncImage(url: URL(string: "https://image.tmdb.org/t/p/original\(movie.posterPath)")){ image in
                    image.resizable()
                } placeholder: {
                    getProgrsssBar()
                }.frame(width: .infinity, height: 500)
            } else {
                // Fallback on earlier versions
            }
                Text(movie.name)
                    .padding(.all, 20.0)
                }
            }
}
